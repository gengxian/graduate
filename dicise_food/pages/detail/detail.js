// pages/detail/detail.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  comment:function(ee){
    console.log(ee.currentTarget.id);
    wx.redirectTo({
      url: '../commentall/commentall?food='+ ee.currentTarget.id,
    })

  },
   commentme:function(e){
     console.log(e);
     /**
      * 这里拿到这个品牌的名称
      */
     console.log(e.currentTarget.id);
         var mingzi=e.currentTarget.id;
         wx.redirectTo({
           url: '../commentme/commentme?food='+mingzi,
         })
        },
          /**
             * 生命周期函数--监听页面加载
                */
                  onLoad: function (options) {
   },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    console.log(options);
    var token = wx.getStorageSync("token");
    console.log("我有拿到token吗"+token);
    //根据点开详情，记录浏览记录，将浏览记录存放进数据库中
    wx.request({
      url: app.globalData.locall +'detail/de',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      data: {
        food:options.detail,
        openid:token
      },
      method: "POST",
      success: function (e) {
        console.log(e.data);
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