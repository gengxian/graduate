const app = getApp();

Page({
  data: {
   
    userInfo: null,  
    hidden:false
  },
  onChangeShowState: function () {

    var that = this;

    that.setData({

      showView: (!that.data.showView)

    })

  },
  onLoad: function (options) {
    var that = this;
    console.log(options);
    console.log(app.globalData.userInfo)
    var token=wx.getStorageSync("token");
    wx.request({
      url: app.globalData.locall+'login/selectuser',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      data: {
        openid: token
      },
      method: "POST",
      success: function (e) {
        console.log(e.data);
        that.setData({
          userInfo: e.data,
        })
      }
    })
  

    // if (token!=null)
    // {
    //   that.setData({
    //     hidden:true,
    //     userInfo: app.globalData.userInfo
    //   });
    // }else{
    //   that.setData({
    //     hidden: false,
    //     userInfo: app.globalData.userInfo
    //   });
    // }
    
  },
  onShow: function () {
    wx.setNavigationBarTitle({
      title: '个人中心'
    });
  },
  about: function (e) {
    wx.showModal({
      title: '提示',
      content: app.globalData.about || '',
      showCancel: false
    });
  }
});
  