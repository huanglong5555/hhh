点对点:一个消息只会被一个接受者接受一次 this.destination = this.session.createQueue("test-queue");
订阅模式：所有订阅者都会接受到消息   this.destination = this.session.createTopic("test-queue");


唯一区别：this.session.createQueue("test-queue")   换成   this.session.createTopic("test-queue");


同步：通过循环接收消息
异步： 通过继承MessageListener