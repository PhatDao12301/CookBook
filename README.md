# Đồ án - *CookBook*

**CookBook** cung cấp cho người dùng những công thức mới nhất được tìm thấy bởi nhóm phát triển LNP. Ứng dụng cung cấp hình ảnh và những thông tin cần thiết của công thức nấu ăn cho người dùng.

Time spent: **10** tuần tổng cộng

## User Stories

Những chức năng **đã hoàn thành**:

* [x] Người dùng có thể trượt để xem danh sách các công thức hiện tại từ nguồn cơ sở dữ liệu **Firebase Database**.
* [x] Layout được tối ưu với **[ViewHolder] pattern** (http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView#improving-performance-with-the-viewholder-pattern).

* [x] Với mỗi công thức được thể hiện, người dùng có thể xem các thông tin:
  * [x] Tên món ăn
  * [x] Hình ảnh món ăn
  * [x] Danh sách nguyên liệu
  * [x] Hướng dẫn thực hiện
  * [x] Video hướng dẫn từ **Youtube API**
  
* [x] Người dùng có thể **kéo để làm mới (pull-to-refresh)** để làm mới danh sách thực đơn.
* [x] Thể hiện một **placeholder mặc định** [placeholder graphic](http://guides.codepath.com/android/Displaying-Images-with-the-Picasso-             Library#configuring-picasso) cho mỗi hình ảnh khi đang chờ loading.
* [x] Sử dụng **Drawer View** và **Navigation Drawer** 
* [x] Hỗ trợ tương tác người dùng (user interface) bằng điều chỉnh style và màu sắc.

## Video hướng dẫn:

Đây là video hướng dẫn sử dụng ứng dụng Cook Book:

<img src='https://i.imgur.com/3ECz2B8.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

## Ghi chú:

## Thư viện mở đã dùng:
- [Picasso](http://square.github.io/picasso/) - Thư viện hỗ trợ tải ảnh và lưu tạm ảnh qua mạng cho Android
- [Glide](https://github.com/bumptech/glide) - Thư viện hỗ trợ tải ảnh và lưu tạm ảnh qua mạng cho Android

## License

    Copyright [2017] [LNP Collections]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
