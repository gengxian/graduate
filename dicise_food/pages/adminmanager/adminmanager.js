// pages/adminmanager/adminmanager.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  

  data: {
    
     information:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    wx.request({
      url: app.globalData.locall +'admin/chakan',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      method: "POST",
      data: {
       
      },
      success: function (e) {
        console.log(e.data);
        //通过openid获取用户的基本的信息
       that.setData({
         information:e.data
       })

      }
    })
  },
  chakan:function(e){
    console.log(e.target.id);
    var food=e.target.id;
    
    wx.redirectTo({
      url: '../admindetail/admindetail?food='+food,
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