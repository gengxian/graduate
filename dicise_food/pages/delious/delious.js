// pages/delious/delious.js
//加载腾讯位置服务js文件（必须）
const app = getApp();

var qqmap = require('../../utils/qqmap-wx-jssdk.min.js')



Page({

  /**
   * 页面的初始数据
   */
  data: {
    searchicon: "/dist/images/searchicon.png"
  },
  ViewClick: function (e)
  {
    console.log(e.currentTarget.dataset.experienceid);
    var detail = e.currentTarget.dataset.experienceid;
    wx.navigateTo({
      url: '/pages/detail/detail?detail='+detail,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    //调用腾讯地图sdk  添加腾讯地图key
    
        var demo = new qqmap({
          key: '42GBZ-BW3WU-5MTV5-BIJV3-O46YT-SAFVF'
  
    });
    //获取当前的位置信息
     wx.getLocation({
       type: 'gcj02',  //编码方式，
       success: function(res) {
         console.log(res);
         var latitude=res.latitude;
         var longitude=res.longitude;
         demo.reverseGeocoder({
           //腾讯地图api,逆解析方法，首先设计经纬度
           location:{
             latitude:res.latitude,
             longitude:res.longitude,
           },
           //逆解析成功回调函数
           success:function(re){
             //拿到当前的定位的城市显示当前城市的菜式
             var city=re.result.ad_info.city;//例如这里拿到了揭阳市
             console.log(re.result.ad_info.city);
             wx.setStorageSync("city", city);
             //请求揭阳市的菜式的数据
             wx.request({
               url: app.globalData.locall +'food/all',
               header: {
                 "Content-Type": "application/json;charset=utf-8"
               },
               method: "POST",
               data:{
                 city: city
               },
               
               success:function(e){
                 console.log(e);
                 that.setData({
                   information: e.data,
                 })

               }
             })

           }
         })
       },
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
    wx.showNavigationBarLoading()
    //在标题栏中显示加载 //模拟加载
    setTimeout(function () { // complete 
      wx.hideNavigationBarLoading() //完成停止加载
      wx.stopPullDownRefresh()
      //停止下拉刷新
    },
      1500);
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    console.log("上啦加载");
    wx.showToast({
      title: '没有更多数据了！',
      image: '/dist/images/logo.jpg',
    })

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    wx.showShareMenu({
      withShareTicket: true
    })
  },
   

})