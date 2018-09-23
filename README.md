# SSM框架
经过这一段时间的学习，我整理了一下Spring+SpringMVC+Mybatis的框架，希望对以后的自己有所帮助
### 结构
   com   
 &emsp;|--company   
   &emsp; &emsp;|--dao   
   &emsp; &emsp;|--service   
     &emsp;&ensp;&ensp;&ensp;&ensp;&ensp;  |--impl  
   &emsp; &emsp;|--controller   
   &emsp; &emsp;|--entity   
   &emsp; &emsp;|--exception   
   &emsp; &emsp;|--interceptor     
   
dao与resource下的mapper相关联，方法名相同，mapper里可使用动态SQL，这里没有写出。dao主要是进行数据库相关操作   
service层调用dao层方法进行逻辑处理     
entity是pojo   
exception是自定义的异常类   
interceptor是拦截器，对请求进行拦截   
controller对请求进行处理和跳转，所有controller继承baseController，baseController中对异常进行捕获和处理   
