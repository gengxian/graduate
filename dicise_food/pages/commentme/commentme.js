// pages/commentme/commentme.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
   search:function(e){
     console.log(e);
     /**
      * 这里拿到评论的值
      id是评论的食物名称
      textarea是评论的内容
      */
      console.log(e.detail.target.id);
     console.log(e.detail.value.textarea);
     var food=e.detail.target.id;
     var commentme=e.detail.value.textarea;
     var token = wx.getStorageSync("token");
     //通过token去查找该用用户用户名
     wx.request({
       url: app.globalData.locall +'comment/nickname',
       header: {
         "Content-Type": "application/json;charset=utf-8"
       },
       method: "POST",
       data: {
        token:token
       },
       success: function (e) {
         console.log(e.data.nickname);  
         var nickname= e.data.nickname;
          wx.request({
            url: app.globalData.locall +'comment/commentme',
       header: {
         "Content-Type": "application/json;charset=utf-8"
       },
       method: "POST",
       data: {
         food:food,
         commentme:commentme,
         nickname:nickname,
       },
       success: function (e) {
         console.log(e);
         wx.redirectTo({
           url: '../commentall/commentall?food=' +e.data,
         })

       }
     })
       }
     })
    
        },
          /**
             * 生命周期函数--监听页面加载
             
   },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
     console.log(options);
     var food=options.food;
    that.setData({
      food:food
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