const app = getApp();
Page({
  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  onLoad: function () {
    var that = this;
    // 查看是否授权
    wx.getSetting({
      success: function (res) {
        if (res.authSetting['scope.userInfo']) {
          wx.getUserInfo({
            success: function (res) {
              var token=wx.getStorageSync("token")
              console.log(token);
              wx.request({
                url: app.globalData.locall +'login/selectuser',
                header: {
                  "Content-Type": "application/json;charset=utf-8"
                },
                method: "POST",
                data: {
                  openid: token,
                },
                success:function(e){
                  console.log(e.data);
                  //通过openid获取用户的基本的信息
                  app.globalData.userInfo=e.data;
                   console.log(e.data);
                  
                }
              })
            
                wx.switchTab({
                  url: '/pages/index/index'
                })
            
             
            }
          });
        }
      }
    })
  },
  bindGetUserInfo: function (e) {
    if (e.detail.userInfo) {
      //用户按了允许授权按钮
      var that = this;
      //保存到全局变量
      // app.globalData.userInfo = e.detail.userInfo;
      var nickName=e.detail.userInfo.nickName;
      var avatarUrl = e.detail.userInfo.avatarUrl;
      var province = e.detail.userInfo.province;
      var city = e.detail.userInfo.city;
      console.log("我这里有拿到用户的信息吗") 
      console.log(city);
      //用户点击允许授权之后获取用户的openid
      var code=wx.getStorageSync("code");
      wx.request({
        url: app.globalData.locall +'login/appid',
          header: {
            "Content-Type": "application/x-www-form-urlencoded"
          },  
          method: "POST",  
          data:{
            code:code,
          },
          success:function(e)
          {
            console.log(nickName);
            var appid=e.data.appid;
            var secret=e.data.secret;
            var url=e.data.url;
            
            //通过appid和secret获取openid
            wx.request({
              url: url,
              method: "GET",  
              data:{
                appid:appid,
                secret:secret,
                js_code:code,
                grant_type: 'authorization_c ode'
              },
              //获取到openid
              success:function(e){
                console.log("我要获取到openid");
                console.log(e);
                //将openid存放进本地c存储中
                wx.setStorageSync("token", e.data.openid);
                var token=wx.getStorageSync("token");
                var openid=e.data.openid;
                //将用户的信息存放进数据库中
                wx.request({
                  url: app.globalData.locall +'login/adduser',
                  header: {
                    "Content-Type": "application/json;charset=utf-8"
                  },
                  method: "POST",  
                  data:{
                    openid:openid,
                    nickname: nickName,
                    picture: avatarUrl,
                    province: province,
                    city: city
                  },
                  success:function(ress){
                    console.log(ress);
                    app.globalData.userInfo=ress.data;
                    
                    if (token == "o2xbX5eP4w3e88iYrVWnsAbIWCww") {
                      wx.switchTab({
                        url: '/pages/index/index',
                      })
                    } else {
                      wx.switchTab({
                        url: '/pages/index/index'
                      })
                    }
                  }

                })
              }
            })
            
          }
      })
    } else {
      //用户按了拒绝按钮
      wx.showModal({
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
        showCancel: false,
        confirmText: '返回授权',
        success: function (res) {
          console.log(res);
          console.log('用户点击了“确定授权”')
          if (res.confirm) {
            console.log('用户点击了“返回授权”')
          }
        }
      })
    }
  },
 

})
