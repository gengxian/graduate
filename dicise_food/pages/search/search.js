const app = getApp();
Page({
  data: {
    searchType: 0,
    hotKeyword: "",
    hotTag: ['早餐', '微辣', '午餐', '宵夜']
  },
  changeSearchType: function (e) {
    var that=this;
    // console.log(e._relatedInfo.anchorTargetText);
    //获取选择的是哪个类型
    var ty = e._relatedInfo.anchorTargetText;
    var types = ['菜名', '地区'];
    var that = this
    wx.showActionSheet({
      itemList: types, 
      success: function (res) {
        console.log(res.tapIndex);
        wx.setStorageSync("ty", res.tapIndex);
        that.setData({
          searchType:res.tapIndex,
        })
      }
    })
  },
  search: function (e) {
    var that = this
    //拿到搜索的词进行判断
    var keyword = e.detail.value.keyword
    console.log(e);
    console.log(wx.getStorageSync("ty"));
    var ty = wx.getStorageSync("ty");
    // console.log(searchType);
    if (keyword == '') {
      wx.showToast({
        title: '请输入内容',
        duration:1500,
      })
      return false
    } else {
      //输入搜索的内容,通过ty的值来判断跳转到哪个页面
      if(ty==0){
        wx.navigateTo({
          url: '../searchresult/searchresult?keyword=' + keyword + '&ty=' + ty
        })
      }
      else{
        wx.navigateTo({
          url: '../searchresult1/searchresult1?keyword=' + keyword + '&ty=' + ty
        })
      }
    
    }
  },
  searchByKeyword: function (e) { 
    console.log(e._relatedInfo.anchorTargetText);
    var detail = e._relatedInfo.anchorTargetText;
    var that = this
    var keyword = e.currentTarget.dataset.keyword
    wx.navigateTo({
      url: '/pages/detail/detail?detail=' + detail,
    })
  },
  searchByTag: function (e) {
    var that = this
    var keyword = e.currentTarget.dataset.keyword
    wx.navigateTo({
      url: '../searchResult/searchResult?url=' + encodeURIComponent(url[1]) + '&keyword=' + keyword
    })
  },
  onLoad: function (options) {
    /**
     * 这里查询搜索量最高四个菜式的进行显示
     */
    var that = this;
   
    wx.request({
      url: app.globalData.locall +'search/fore',
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      data: {
       
      },

      method: "POST",
      success: function (e) {
        console.log("我拿点击量最多前四的");
        console.log(e.data);
        var er=e.data;
         that.setData({
           hotKeyword:er
         })
      }
    })
  },
})