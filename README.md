ServletContextListener_Demo
===========================

Servlet侦听器的例子
在 Servlet API 中有一个 ServletContextListener 接口，它能够监听 ServletContext 对象的生命周期,<br>
实际上就是监听 Web 应用的生命周期。
当Servlet 容器启动或终止Web 应用时，会触发ServletContextEvent 事件，该事件由ServletContextListener 来处理。
在 ServletContextListener 接口中定义了处理ServletContextEvent 事件的两个方法。
