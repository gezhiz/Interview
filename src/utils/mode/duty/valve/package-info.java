/**
 * Created by gezz on 2017/9/1.
 */
package utils.mode.duty.valve;

/**
 * 责任链设计模式的案例，源自Tomcat4源码的责任链简化版本，执行ValvesDutyTest的test方法可以启动整条责任链
 *
 *  设计思路：
 *  1、实现一个标准的节点类（StandardPipeline）,需要实现加入链路的类只需要引用标准的节点对象
 *  2、每一个引入了Pipeline的载体（Container）都拥有一个基本的阀门（Valve）basicValve,
 *  标准节点（StandardPipeline）通过载体拿到basicValve后选取下一个Container处理。
 */