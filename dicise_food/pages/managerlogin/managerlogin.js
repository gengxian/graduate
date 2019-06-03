const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  formSubmit: function (e) {
    // console.log(e.detail.value);
    wx.request({
      // url: 'https://www.lishuming.top/pj/index.php/student/api/login', //仅为示例，并非真实的接口地址
      url: app.globalData.locall +'admin/adminlogin',
      data: {
        username: e.detail.value.no,
        password: e.detail.value.pwd
      },
      header: {
        "Content-Type": "application/json;charset=utf-8"
      },
      method: "POST",
      success: function (res) {
        console.log(res.data);
          if(res.data==200){
            wx.showToast({
              title: '登录成功',
              icon:"seccess",
              duration:1000,
              success:function(e){
                wx.redirectTo({
                  url: '../adminmanager/adminmanager',
                })
              }

            })
          }
          else{
            wx.showToast({
              title: '登录失败',
              icon: "fail",
              duration: 1000,
              success: function (e) {
                wx.navigateTo({
                  url: '../managerlogin/managerlogin',
                })
              }

            })
          }
          
        

      }
    })
  }
})
    