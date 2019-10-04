#### 项目整体的结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191004233511595.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2l0X2lzX21lX2E=,size_16,color_FFFFFF,t_70)

#### Java实现“伪QQ”的功能有：

1. 实现了QQ登录界面，好友列表界面，聊天界面以及服务器界面。
2. 进行了验证账户是否正确的功能，如果错误，提示错误信息
3. 多个好友同时在线聊天功能
4. 好友在线显示彩色头像，不在线显示灰色头像
5. 好友上线时刷新所有在线人数。

#### 界面如何实现，以好友列表为例

我们实现的好友列表如下图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191004233622625.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2l0X2lzX21lX2E=,size_16,color_FFFFFF,t_70)

这个界面怎么做的呢？

首先是一个大的长方形里面包含了二部分，我的好友部分，黑名单。

大的长方形用一个 JPanel 来实现它，起名为jb1

中间显示的部分整体也是一个 JPanel 起名为jb2

黑名单是一个 JPanel 起名为jb3

再看具体的：首先我的好友部分包括上面的按键“我的好友”。中间的一大列好友名单，以后右侧的滚动条，滚动条的实现 JScrollPane
好友的实现：每一个好友是一个 JPanel ，所以用 JPanel数组实现。

 jb3 由一个1行1列组成，其中上面包含一个按钮黑名单。
 
 
#### 如何在网络间传递对象流。
一般我们连接到客户端后，都是使用readLine()来读取数据，但是这种方法其实不好，这里我们用对象流来传递消息。

```java
// 以前接受的方式
BufferedReader <u>br</u> = new BufferedReader(new InputStreamReader(s.getInputStream()));

String info = br.readLine();
```
注意，在使用对象进行传输的时候，得在类后面添加`implements java.io.Serializable`，目的是为对象的序列化。
```java
//接收数据
ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
User u = (User)ois.readObject();
```


-------------------------------
最后待完成的功能：

- 注册功能，并将数据添加到数据库
- 在数据库中进行账号验证
- 多对多聊天
- 不让同一个账号反复登录
- 如果好友不在线，则不能聊天
- 文件传输功能
- 加密功能
- 黑名单功能
- 服务器界面的完善，主要是监听所有的用户状态（在线、不在线）

