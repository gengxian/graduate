// pages/recommend/recommend.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    searchType: "协同过滤",
    searchicon: "/dist/images/searchicon.png"
  },
  ViewClick: function (e) {
    console.log(e.currentTarget.dataset.experienceid);
    var detail = e.currentTarget.dataset.experienceid;
    wx.navigateTo({
      url: '/pages/detail/detail?detail=' + detail,
    })
  },
  changeSearchType: function (e) {
    var that=this;
    // console.log(e._relatedInfo.anchorTargetText);
    //获取选择的是哪个类型
    var ty = e._relatedInfo.anchorTargetText;
    var types = ['协同过滤', '其他算法','login算法'];
    var that = this
    wx.showActionSheet({
      itemList: types,
      success: function (res) {

        console.log(res.tapIndex);
        wx.setStorageSync("ty", res.tapIndex);
        if(res.tapIndex==0){
          that.setData({
            searchType: "协同过滤"
          })
        }else if(res.tapIndex==1)
        {
          that.setData({
            searchType:"其他算法"
          })
        }
        else{
          that.setData({
            searchType:"login算法"
          })
        }
       
      }
    })
  },
  onShow:function(options){
    var that = this;
    var token = wx.getStorageSync("token");
    wx.request({
      url: app.globalData.locall +'recommend/usercf',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      data: {
        food: "无敌",
        token: token
      },

      method: "POST",
      success: function (e) {
        console.log(e);
        console.log(e.data.status);
        if (e.data.status == 500) {
          wx.showToast({
            title: '新用户暂时没有推荐',
          })
        } else {
          that.setData({
            information: e.data,
          })
        }

      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    var token=wx.getStorageSync("token");
    wx.request({
      url: app.globalData.locall +'recommend/usercf',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      data: {
        food:"无敌",
        token:token
      },

      method: "POST",
      success: function (e) {
        console.log(e);
        console.log(e.data.status);
        if (e.data.status==500){
          wx.showToast({
            title: '新用户暂时没有推荐',
          })
        }else{
          that.setData({
            information: e.data,
          })
        }
        
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