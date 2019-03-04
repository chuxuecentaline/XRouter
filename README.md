# XRouter
 用于组件化开发

 1. ServiceFactory 组件页面跳转 支持 startActivity  startActivityForResult
    使用方法 1. 在Application  中   ServiceFactory.init(this); 初始化
             2. 没新增一个服务都要在 Application 中的initialzation() 配置服务
             例如  ServiceFactory.getInstance().addService(new LoginServiceImpl());
 仿ButterKnife 实现findViewById
             1. 局限性不能在组件化开发使用，因为采用的是编译时注解
