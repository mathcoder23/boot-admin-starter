package org.utils.netty.annotation;

import org.springframework.core.annotation.AliasFor;
import org.utils.netty.enums.PortType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ServerEndpoint {

    @AliasFor("path")
    String value() default "/";

    @AliasFor("value")
    String path() default "/";

    String caPath() default "cert/ca.crt";
    String keyPath() default "cert/key.pem";

    String serverName() default "";

    /**
     * 此开关为使能开关,开启后,通过sslEnable环境变量来控制是否开启ssl
     * @return
     */
    boolean enableSsl() default false;

    String host() default "0.0.0.0";

    int port() default 80;

    /**
     * 主线程数量,为0则取默认值
     */
    int bossLoopGroupThreads() default 0;

    /**
     * 子线程数量,为0则取默认值
     */
    int workerLoopGroupThreads() default 0;

    /**
     * 数据压缩
     */
    boolean useCompressionHandler() default false;

    /**
     * if this property is not empty, means configure with application.properties
     */
    String prefix() default "";

    //------------------------- option -------------------------

    /**
     * 连接超时毫秒数，默认值30000毫秒即30秒
     */
    int optionConnectTimeoutMillis() default 30000;

    /**
     * 服务端接受连接的队列长度，如果队列已满，客户端连接将被拒绝。默认值，Windows为200，其他为128
     */
    int optionSoBacklog() default 128;

    //------------------------- childOption -------------------------

    /**
     * 一个Loop写操作执行的最大次数，默认值为16。也就是说，对于大数据量的写操作至多进行16次，如果16次仍没有全部写完数据，
     * 此时会提交一个新的写任务给EventLoop，任务将在下次调度继续执行。这样，其他的写请求才能被响应不会因为单个大数据量写请求而耽误
     */
    int childOptionWriteSpinCount() default 16;

    /**
     * 写高水位标记，默认值64KB。如果Netty的写缓冲区中的字节超过该值，Channel的isWritable()返回False
     */
    int childOptionWriteBufferHighWaterMark() default 64 * 1024;

    /**
     * 写低水位标记，默认值32KB。当Netty的写缓冲区中的字节超过高水位之后若下降到低水位，则Channel的isWritable()返回True。
     * 写高低水位标记使用户可以控制写入数据速度，从而实现流量控制。推荐做法是：每次调用channl.write(msg)方法首先调用channel.isWritable()判断是否可写
     */
    int childOptionWriteBufferLowWaterMark() default 32 * 1024;

    /**
     * TCP数据接收缓冲区大小。该缓冲区即TCP接收滑动窗口，linux操作系统可使用命令：cat /proc/sys/net/ipv4/tcp_rmem查询其大小。
     * 一般情况下，该值可由用户在任意时刻设置，但当设置值超过64KB时，需要在连接到远端之前设置
     */
    int childOptionSoRcvbuf() default -1;

    /**
     * TCP数据发送缓冲区大小。该缓冲区即TCP发送滑动窗口，linux操作系统可使用命令：cat /proc/sys/net/ipv4/tcp_smem查询其大小
     */
    int childOptionSoSndbuf() default -1;

    /**
     * TCP参数，立即发送数据，默认值为Ture（Netty默认为True而操作系统默认为False）。该值设置Nagle算法的启用，
     * 该算法将小的碎片数据连接成更大的报文来最小化所发送的报文的数量，如果需要发送一些较小的报文，则需要禁用该算法。Netty默认禁用该算法，从而最小化报文传输延时
     */
    boolean childOptionTcpNodelay() default true;

    /**
     * 连接保活，默认值为true。启用该功能时，TCP会主动探测空闲连接的有效性。
     * 可以将此功能视为TCP的心跳机制，需要注意的是：默认的心跳间隔是7200s即2小时。Netty默认关闭该功能
     */
    boolean childOptionSoKeepalive() default true;

    /**
     * 关闭Socket的延迟时间，默认值为-1，表示禁用该功能。-1表示socket.close()方法立即返回，但OS底层会将发送缓冲区全部发送到对端。
     * 0表示socket.close()方法立即返回，OS放弃发送缓冲区的数据直接向对端发送RST包，对端收到复位错误。
     * 非0整数值表示调用socket.close()方法的线程被阻塞直到延迟时间到或发送缓冲区中的数据发送完毕，若超时，则对端会收到复位错误
     */
    int childOptionSoLinger() default -1;

    /**
     * 一个连接的远端关闭时本地端是否关闭，默认值为False。值为False时，连接自动关闭；
     * 为True时，触发ChannelInboundHandler的userEventTriggered()方法，事件为ChannelInputShutdownEvent
     */
    boolean childOptionAllowHalfClosure() default false;

    //------------------------- idleEvent -------------------------

    int readerIdleTimeSeconds() default 0;

    int writerIdleTimeSeconds() default 0;

    int allIdleTimeSeconds() default 0;

    //------------------------- handshake -------------------------

    int maxFramePayloadLength() default 65536;

    //端口生成模式，0随机，1固定，2配置
    PortType portType() default PortType.FIXED;

    //是否开启心跳
    boolean enableHeartBeat() default false;

}
