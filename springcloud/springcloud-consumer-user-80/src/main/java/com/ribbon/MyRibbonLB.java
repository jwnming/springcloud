package com.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;


/**
 * @author 蒋文明
 * 自定义Rinbbon负载均衡
 */
public class MyRibbonLB extends AbstractLoadBalancerRule {

    // 全局变量，处理微服务负载策略参数
    private int total = 0;
    private int curr = 0;


    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    /**
     * 自定义微服务访问负载策略
     * @param o
     * @return
     */
    public Server choose(Object o) {
        ILoadBalancer lb = getLoadBalancer();

        if (lb == null) {
            return null;
        }

        Server server = null;

        while(server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            // 获取或者的微服务
            List<Server> upList = lb.getReachableServers();
            // 获得所有的微服务
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            if (total < 2) {
                total++;
                server = (Server) upList.get(curr); // 获取当前索引的微服务
            } else {
                total = 0;
                curr++;
                if (curr > upList.size()) {
                    curr = 0;
                }
                server = (Server) upList.get(curr); // 获取当前索引的微服务
                System.out.println("MyRibbonLB，切换服务：" + server.getHost() + ":" + server.getHostPort());
            }

            if (server == null) {
                Thread.yield();
            } else {
                if (server.isAlive()) {
                    return server;
                }

                server = null;
                Thread.yield();
            }
        }

        return server;

    }
}
