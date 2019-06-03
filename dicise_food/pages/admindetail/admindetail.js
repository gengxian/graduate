const app = getApp();
// pages/admindetail/admindetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
   console.log(options);
   wx.request({
     url: app.globalData.locall +'admin/detail',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      method: "POST",
      data: {
        food:options.food,
      },
      success: function (e) {
        console.log(e.data.application);
        that.setData({
          information:e.data.application,
        })

      }
    })
  },
  pass:function(e){
    var that=this;
     console.log(e.currentTarget.id);
    var food = e.currentTarget.id;
    wx.request({
      url: app.globalData.locall +'admin/pass',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      method: "POST",
      data: {
        food:food,
      },
      success: function (e) {
       console.log(e);
        wx.redirectTo({
          url: '../adminmanager/adminmanager',
        })
      }
    })
  },
  notpass:function(e){
    var that=this;
    console.log(e.currentTarget.id);
    wx.request({
      url: app.globalData.locall +'admin/notpass',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      method: "POST",
      data: {
        food:e.currentTarget.id,
      },
      success: function (e) {
       console.log(e);
       wx.navigateTo({
         url: '../adminmanager/adminmanager',
       })

      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})