# SSM框架

整理了一下Spring+SpringMVC+Mybatis的框架，希望对以后的自己有所帮助

### 结构

   com   
  |--company   
      |--dao   
      |--service   
             |--impl  
      |--controller   
      |--entity   
      |--exception   
      |--interceptor     

dao与resource下的mapper相关联，方法名相同，mapper里可使用动态SQL，这里没有写出。dao主要是进行数据库相关操作   
service层调用dao层方法进行逻辑处理     
entity是pojo   
exception是自定义的异常类   
interceptor是拦截器，对请求进行拦截   
controller对请求进行处理和跳转，所有controller继承baseController，baseController中对异常进行捕获和处理   

#### 配置文件

web.xml中dispachterServlet以及关联spring配置文件。过滤器的配置   
spring-mybatis.xml是spring整合mybatis的配置文件   
mybatis-config中配置的是entity类的别名，以便在mapper文件中使用      
mapper文件中可以通过使用动态SQL完成更加复杂的逻辑，这里没有写出。
