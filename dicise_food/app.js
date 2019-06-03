//app.js
App({
  onLaunch: function () {
    //查看是否已经存放了token
   var token=wx.getStorageSync("token");
   console.log("我拿到token了吗")
   console.log(token);
   

   //进入小程序之前获取到code,并存放与本地中
    wx.login({
      success: res => {
        console.log(res);
        wx.setStorageSync("code",res.code);
      }
    })
    //通过token判断是否需要进行授权登录
   if(token==""||token==null)
   {
     console.log("我没有授权登录");
     //跳转到授权登录页面
     wx.navigateTo({
       url: '/pages/authorize/authorize',
     })
   }
   
   
  },
  globalData: {
    userInfo: null,
    about: '此项目长期维护，如有需要可以找我进行下载，感觉还不错可以给作者star',
    locall:'http://127.0.0.1:8080/',
  }
}) 
// {
      //   "pagePath": "pages/koubei/koubei",
      //   "iconPath": "dist/images/top_icon.png",
      //   "selectedIconPath": "dist/images/top_active_icon.png",
      //   "text": "口碑"
      // },