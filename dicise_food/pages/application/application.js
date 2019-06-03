const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    src:""

  },
  formSubmit: function (e) {
     console.log(e.detail.value);
    var urlpath = wx.getStorageSync("urlpath");
    wx.request({
      url: app.globalData.locall +'admin/admincheck',
      data: {
        food: e.detail.value.food,
        foodtype: e.detail.value.foodtype,
        description: e.detail.value.description,
        belong: e.detail.value.belong,
        opcreate: e.detail.value.opcreate,
        urlpath: app.globalData.urlpath,
      },
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      method: "POST",
      success: function (res) {
        console.log(res.data);
        if (res.statusCode == 200) {
          //访问正常
          if (res.data.error == true) {
            wx.showToast({
              title: res.data.msg,
              icon: 'none',
              duration: 2000,
            })
          } else {
            //缓存
            wx.setStorage({
              key: "student",
              data: res.data.student
            });
            wx.showToast({
              title: "申请成功",
              icon: 'success',
              duration: 2000,
              success: function () {
                setTimeout(function () {
                  wx.switchTab({
                    url: '../index/index',
                  })
                }, 2000)
              }
            })
          }
        }

      }
    })
  },
  chooseImage: function () { 
  var that = this; 
  // console.log('aaaaaaaaaaaaaaaaaaaa') 
   
  wx.chooseImage({ 
   count: this.data.count[this.data.countIndex], 
   success: function (res) { 
    // console.log('ssssssssssssssssssssssssss') 
    //缓存下 
    wx.showToast({ 
     title: '正在上传...', 
     icon: 'loading', 
     mask: true, 
     duration: 2000, 
     success: function (ress) { 
      console.log('成功加载动画'); 
     } 
    }) 
  
    console.log(res) 
    that.setData({ 
     imageList: res.tempFilePaths 
    }) 
    //获取第一张图片地址 
    var filep = res.tempFilePaths[0] 
    //向服务器端上传图片 
    // getApp().data.servsers,这是在app.js文件里定义的后端服务器地址 
    wx.uploadFile({ 
     url: getApp().data.servsers + '/weixin/wx_upload.do', 
     filePath: filep, 
     name: 'file', 
     formData: { 
      'user': 'test'
     }, 
     success: function (res) { 
      console.log(res) 
      console.log(res.data) 
      var sss= JSON.parse(res.data) 
      var dizhi = sss.dizhi; 
      //输出图片地址 
      console.log(dizhi); 
      that.setData({ 
       "dizhi": dizhi 
      }) 
  
      //do something  
     }, fail: function (err) { 
      console.log(err) 
     }  
      }); 
   } 
  }) 
 }, 
 previewImage: function (e) { 
  var current = e.target.dataset.src 
  
  wx.previewImage({ 
  
   current: current, 
   urls: this.data.imageList 
  }) 
 },
 ttt:function(){
   var that=this;
   wx.chooseImage({
     count: 1, // 默认9
     sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
     sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
     success: function (res) {
       // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
       var path = res.tempFilePaths
        wx.saveFile({
          tempFilePath: path[0],
          success:function(e){
            console.log(e);
            var url = e.savedFilePath;
            app.globalData.urlpath=e.savedFilePath;
            that.setData({
              src: e.savedFilePath,
            })
            
          }
        })
     }
   })
 }
})
