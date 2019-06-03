// pages/searchresult/searchresult.js
const app = getApp();
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
    //获取到输入的内容
    console.log(options.keyword);
    //获取到选择的类型，0代表菜名
    console.log(options.ty);
    wx.request({
      url: app.globalData.locall +'search/result',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      data: {
        food: options.keyword
      },
      method: "POST",
      success: function (e) {
        console.log(e);
        that.setData({
          information: e.data,
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