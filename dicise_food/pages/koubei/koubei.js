// pages/koubei/koubei.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    searchicon: "/dist/images/searchicon.png"
  },
  ViewClick: function (e) {
    console.log(e.currentTarget.dataset.experienceid);
    var detail = e.currentTarget.dataset.experienceid;
    wx.navigateTo({
      url: '/pages/detail/detail?detail=' + detail,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    //请求揭阳市的菜式的数据
    wx.request({
      url: app.globalData.locall +'food/top',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      method: "POST",
      data: {
        
      },

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