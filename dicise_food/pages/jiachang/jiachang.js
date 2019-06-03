// pages/jiachang/jiachang.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    searchicon: "/dist/images/searchicon.png",
    title:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
       console.log(options);
       var title=options.title;
       //通过前面的title的数值来判断来决定要显示哪些内容
       if(title=="0"){
        //家常菜
        wx.request({
          url: app.globalData.locall +'classification/jia',
          header: {
            "Content-Type": "application/json;charset=utf-8"
          },
          data: {
            foodtype: "家常菜"
          },
          method: "POST",
          success: function (e) {
            console.log(e);
            that.setData({
              information: e.data,
            })
          }
        })

       } else if (title == "1"){
         //早餐，显示早餐的列表
         wx.request({
           url: app.globalData.locall +'classification/zao',
           header: {
             "Content-Type": "application/json;charset=utf-8"
           },
           data:{
             foodtype:"早餐"
           },
           method: "POST",
           success:function(e){
             console.log(e);
             that.setData({
               information: e.data,
             })
           }
         })


       } else if (title == "2") {
          //凉菜
         wx.request({
           url: app.globalData.locall +'classification/liang',
           header: {
             "Content-Type": "application/json;charset=utf-8"
           },
           data: {
             foodtype:"凉菜"
           },
           method: "POST",
           success: function (e) {
             console.log(e);
             that.setData({
               information: e.data,
             })
           }
         })
       } else if (title == "3") {
           //烘焙
         wx.request({
           url: app.globalData.locall +'classification/hong',
           header: {
             "Content-Type": "application/json;charset=utf-8"
           },
           data: {
             foodtype:"烘焙"
           },
           method: "POST",
           success: function (e) {
             console.log(e);
             that.setData({
               information: e.data,
             })
           }
         })
       } else if (title == "4") {
            //瘦身
         wx.request({
           url: app.globalData.locall +'classification/shou',
           header: {
             "Content-Type": "application/json;charset=utf-8"
           },
           data: {
             foodtype:"瘦身"
           },
           method: "POST",
           success: function (e) {
             console.log(e);
             that.setData({
               information: e.data,
             })
           }
         })
       } else if (title == "5") {
            //养生
         wx.request({
           url: app.globalData.locall +'classification/yang',
           header: {
             "Content-Type": "application/json;charset=utf-8"
           },
           data: {
             foodtype:"养生"
           },
           method: "POST",
           success: function (e) {
             console.log(e);
             that.setData({
               information: e.data,
             })
           }
         })
       } else if (title == "6") {
             //海鲜
         wx.request({
           url: app.globalData.locall +'classification/hai',
           header: {
             "Content-Type": "application/json;charset=utf-8"
           },
           data: {
             foodtype:"海鲜"
           },
           method: "POST",
           success: function (e) {
             console.log(e);
             that.setData({
               information: e.data,
             })
           }
         })
       } else if (title == "7") {
             //靓汤
         wx.request({
           url: app.globalData.locall +'classification/tang',
           header: {
             "Content-Type": "application/json;charset=utf-8"
           },
           data: {
             foodtype: "靓汤"
           },
           method: "POST",
           success: function (e) {
             console.log(e);
             that.setData({
               information: e.data,
             })
           }
         })
       }
  },

  ViewClick: function (e) {
    console.log(e.currentTarget.dataset.experienceid);
    var detail = e.currentTarget.dataset.experienceid;
    wx.navigateTo({
      url: '/pages/detail/detail?detail=' + detail,
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