# ClassicSubscription
新闻订阅 ClassicSubscription


![https://github.com/classichu/ClassicSubscription/blob/master/screenshots/pic.png](https://github.com/classichu/ClassicSubscription/blob/master/screenshots/pic.png)



Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}Copy
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.classichu:ClassicSubscription:x.x.x'
	}


use


      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<SubscriptionBean> subscriptionBeanList = new SubscriptionBeanParse()
                .addMyItemBean(new ItemBean("test1", "测试1", true))
                .addMyItemBean(new ItemBean("test2", "测试2", true))
                .addMyItemBean(new ItemBean("test3", "测试3"))
                .addMyItemBean(new ItemBean("test4", "测试4"))
                .addMyItemBean(new ItemBean("test5", "测试5"))
                .addMoreItemBean(new ItemBean("dsada1", "测试6"))
                .addMoreItemBean(new ItemBean("dsada2", "测试7"))
                .addMoreItemBean(new ItemBean("dsada3", "测试8"))
                .addMoreItemBean(new ItemBean("dsada4", "测试9"))
                .addMoreItemBean(new ItemBean("dsada5", "测试10"))
                .addMoreItemBean(new ItemBean("dsada5", "测试11"))
                .addMoreItemBean(new ItemBean("dsada5", "测试12"))
                .generateData();


        mClassicSubscriptionFragment = ClassicSubscriptionFragment.newInstance("", "", new SubscriptionDataWrapper(subscriptionBeanList));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_frame_layout_content, mClassicSubscriptionFragment)
                .commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_finish, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_menu_finish:
                getData(mClassicSubscriptionFragment.getSubscriptionItemBeanList());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData(List<ItemBean> itemBeanList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itemBeanList.size(); i++) {
            sb.append(itemBeanList.get(i).getTitle());
        }
        Toast.makeText(MainActivity.this, "订阅：" + sb.toString(), Toast.LENGTH_SHORT).show();
    }