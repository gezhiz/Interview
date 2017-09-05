/**
 * Created by gezz on 2017/9/1.
 */
package utils.mode.duty.basic;
/**
 * 责任链的一个基本的实现方式，每一个客户端通过实现DutyHandler接口，继承DutyHandlerBase类的实现
 * 缺点：耦合太强了，都依赖于基类的实现
 * 节点之间的链接依赖自身的setBasicHandler
 */