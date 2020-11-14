package component;


import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

public class testRedis {

    @Test
    public void test() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.161.128");
        // 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
        // jedis.auth("123456");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
