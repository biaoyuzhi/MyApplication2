本项目只用来测试华为PUSH服务的实现。PUSH服务的实现包括APP端的代码开发和服务端的代码开发，
该项目只是APP端的全部代码，主要实现APP和hms（华为移动服务）的集成和PUSH_TOKEN（该token值需传送给服务端，即成为服务端的deviceToken）的获取。
服务端的代码主要实现消息体的编写和获得一个有过期时间的access_token后向deviceToken推送。deviceToken即APP端传过来的PUSH_TOKEN（目标设备Token），它用于识别某一手机上的某一APP。
当然，如果只有APP的开发，可以使用华为开发者联盟的PUSH->新增推送，来完成服务端的类似功能（消息的编写和发送）。注意，该操作使用的Token只需用到APP端自己获得的PUSH_TOKEN。

本项目使用的主要配置如下：
Android Studio3.2，JDK1.8，gradle4.6，HMS Agent2.6.3.301，HMS SDK2.6.3.301
本APP项目主要包括的内容：
MyApplication2
    |
    |- app
    |    |
    |    |- src
    |    |    |-  main
    |    |           |-java
    |    |           |   |-myapplication：三个必须的类：XXXRevicer，XXXApplication，XXXActivity。XXXActivity是作为启动页面的类。
    |    |           |   |-agent：华为HMS Agent套件，需自动生成好后copy过来（自动生成的copysrc文件夹中）。
    |    |           |
    |    |           |-res
    |    |           |   |-layout：这里制作几个简单按钮，用于直观的观察华为PUSH服务的各个方法实现，最主要的是能够直观的获取到PUSH_TOKEN值。该部分设计实际项目中可以灵活集成。
    |    |           |
    |    |           |-AndroidManifest.xml：该文件参考华为HMS Agent套件自动生成文件中的AndroidManifest.xml文件，只需修改3-4个android:name=""的包名即可，主要为了指向实际创建的myapplication包下的三个类（XXXRevicer，XXXApplication，XXXActivity）。
    |    |
    |    |-  build.gradle：注意implementation  'com.huawei.android.hms:push:2.6.3.301'的引入和signingConfigs{}签名文件路径的引入。
    |    |-  proguard-rules.pro：如果build.gradle中实现了混淆，该文件中一定要加入排除hms的混淆配置。
    |
    |- build.gradle：加上一个maven仓库地址，allprojects {repositories { maven {url 'http://developer.huawei.com/repo/'}}}

