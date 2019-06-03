const app = getApp();

Page({
  data: {
    showView: true,
    userInfo: null,
  },
  onChangeShowState: function () {

    var that = this;

    that.setData({

      showView: (!that.data.showView)

    })

  },
  onLoad: function (options) {
    var that = this;
    console.log(app.globalData.userInfo)
    that.setData({
      userInfo: app.globalData.userInfo
    });
  },
  onShow: function () {
    wx.setNavigationBarTitle({
      title: '管理者中心'
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
