# ClassicSubscription
新闻订阅 ClassicSubscription


![https://github.com/classichu/ClassicSubscription/blob/master/screenshots/pic.png](https://github.com/classichu/ClassicSubscription/blob/master/screenshots/pic.png)






    List<SubscriptionBean> subscriptionBeanList =new SubscriptionBeanParse()
                .addMyItemBean(new ItemBean("test1","测试1",true))
                .addMyItemBean(new ItemBean("test2","测试2",true))
                .addMyItemBean(new ItemBean("test3","测试3"))
                .addMyItemBean(new ItemBean("test4","测试4"))
                .addMyItemBean(new ItemBean("test5","测试5"))
                .addMoreItemBean(new ItemBean("dsada1","测试6"))
                .addMoreItemBean(new ItemBean("dsada2","测试7"))
                .addMoreItemBean(new ItemBean("dsada3","测试8"))
                .addMoreItemBean(new ItemBean("dsada4","测试9"))
                .addMoreItemBean(new ItemBean("dsada5","测试10"))
                .addMoreItemBean(new ItemBean("dsada5","测试11"))
                .addMoreItemBean(new ItemBean("dsada5","测试12"))
                .generateData();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_frame_layout_content,
                        ClassicSubscriptionFragment.newInstance("","",
                                new SubscriptionDataWrapper(subscriptionBeanList)))
                .commitAllowingStateLoss();