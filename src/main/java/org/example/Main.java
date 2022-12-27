package org.example;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

public class Main {
    public static void main(String[] args) {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
// 2. Create Redisson instance

// Sync and Async API
        RedissonClient redisson = Redisson.create(config);

// Reactive API
        RedissonReactiveClient redissonReactive = redisson.reactive();

// RxJava3 API
        RedissonRxClient redissonRx = redisson.rxJava();
// 3. Get Redis based implementation of java.util.concurrent.ConcurrentMap
        RMap<String, String> map = redisson.getMap("myMap");

        RMapReactive<String, String> mapReactive = redissonReactive.getMap("myMap");

        RMapRx<String, String> mapRx = redissonRx.getMap("myMap");
// 4. Get Redis based implementation of java.util.concurrent.locks.Lock
        RLock lock = redisson.getLock("myLock");

        RLockReactive lockReactive = redissonReactive.getLock("myLock");

        RLockRx lockRx = redissonRx.getLock("myLock");
// 4. Get Redis based implementation of java.util.concurrent.ExecutorService
        RExecutorService executor = redisson.getExecutorService("myExecutorService");
    }
}