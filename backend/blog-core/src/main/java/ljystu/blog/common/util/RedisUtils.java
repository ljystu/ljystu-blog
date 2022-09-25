package ljystu.blog.common.util;

import com.qiniu.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


/**
 * Redis
 *
 * @Author: ljystu
 * @Date: 25/09/2022-14:54
 */

@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private HashOperations<String, String, Object> hashOperations;
    @Autowired
    private ListOperations<String, Object> listOperations;
    @Autowired
    private SetOperations<String, Object> setOperations;
    @Autowired
    private ZSetOperations<String, Object> zSetOperations;
    /**
     * default expire seconds
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**
     * No expire
     */
    public final static long NOT_EXPIRE = -1;

    /**
     * @param key
     * @param value
     * @param expire
     */
    public void set(String key, Object value, long expire) {
        redisTemplate.opsForValue().set(key, JsonUtils.toJson(value));
//        valueOperations.set(key, JsonUtils.toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * Degfault expire 1 day
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    /**
     * 获取对象，同时设置过期时间
     *
     * @param key
     * @param clazz
     * @param expire
     * @param <T>
     * @return
     */
    public <T> T getObj(String key, Class<T> clazz, long expire) {
        String value = (String) redisTemplate.opsForValue().get(key);
//                 valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : JsonUtils.toObj(value, clazz);
    }

    /**
     * 获取对象，不设置过期时间
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getObj(String key, Class<T> clazz) {
        return getObj(key, clazz, NOT_EXPIRE);
    }

    /**
     * 获取值，同时设置过期时间
     *
     * @param key
     * @param expire
     * @return
     */
    public String get(String key, long expire) {
        String value = redisTemplate.opsForValue().get(key).toString();
//                valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    /**
     * 获取值，不设置过期时间
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    /**
     * 删除
     *
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 更新过期时间
     *
     * @param key
     */
    public void updateExpire(String key) {
        redisTemplate.expire(key, DEFAULT_EXPIRE, TimeUnit.SECONDS);
    }


}
