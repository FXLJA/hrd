Aplikasi Simulasi HRD - User Manual <br>
###################################

Daftar isi <br>
##########
1. Deskripsi Program
2. Relasi Tabel
3. Informasi Pemakaian

----------------------------------------------------------------------------------------------------

1. Deskripsi Program <br>
####################

Aplikasi ini dibuat dengan menggunakan bahasa pemrograman Java, memakai IDE NetBeans versi 10.0,
dan terdiri dari 8 tabel yang menyusun sebuah database yang terkoneksi dengan sebuah simulasi 
RDBMS (Relational Database Management System) dari MariaDB dengan aplikasi simulator database XAMPP.

Semua tabel yang dibuat kemudian akan menampung informasi masing-masing ke dalam database MySQL 
dengan kemampuan CRUD (Create - Read - Update - Delete). User bisa menginput data baru selama data 
sesuai dengan kemampuan penyimpanan tabel, melihat isi tabel melalui JTable yang disediakan oleh 
pembuat program, meng-update salah satu entry dalam tabel (dengan batasan tertentu), dan menghapus 
entry dari tabel.

Setelah seluruh tabel terkoneksi dengan database MySQL melalui class "Koneksi", maka aplikasi 
sudah dapat berfungsi penuh. Koneksi dapat dibuat dengan menjalankan aplikasi XAMPP dan 
meng-enable opsi Apache dan MySQL dari XAMPP Control Panel. Database dapat diakses secara langsung 
melalui Command Prompt atau layanan PHPMyAdmin dari XAMPP.

Semua tabel yang dibuat kemudian akan dipanggil secara on-demand oleh user melalui sebuah MDI
Application Form. MDI Form tersebut berfungsi sebagai sebuah Main Menu, dan akan berfungsi secara 
independen dari tabel-tabel yang terpanggil. Dengan cara ini, maka user bisa mengoperasikan lebih 
dari 1 tabel dalam Main Menu secara bersamaan.


2. Relasi Tabel <br>
############### <br>
Dari 8 tabel yang dibuat, tabel-tabel tersebut terbagi menjadi dua kelompok yang didefinisikan 
sendiri oleh pembuat program, yaitu kelompok SOURCES dan kelompok IMPLEMENTS. 

Kelompok SOURCES adalah tabel-tabel yang berfungsi menyediakan informasi mendasar yang akan 
digunakan di tabel lain atau merupakan salah satu syarat untuk menentukan apakah tabel lain 
bisa / boleh diisi atau tidak.
Kelompok IMPLEMENTS adalah tabel-tabel yang menerapkan gabungan informasi dari tabel-tabel SOURCES 
berdasarkan syarat yang dibuat oleh pembuat program melalui file source code.

Tabel-tabel tersebut adalah sebagai berikut:
Tabel SOURCES
a. Tabel Jabatan <br>
   Tabel ini menyediakan jenis-jenis jabatan yang tersedia untuk dipilih oleh user.
   Nilai yang ditampung oleh tabel berupa kode jabatan dan nama jabatan.

b. Tabel Divisi <br>
   Tabel ini menyediakan jenis-jenis divisi yang tersedia untuk dipilih oleh user.
   Nilai yang ditampung oleh tabel berupa kode divisi dan nama divisi. 

c. Tabel Tunjangan <br>
   Tabel ini menyediakan jenis-jenis tunjangan yang tersedia untuk dipilih oleh user.
   Nilai yang ditampung oleh tabel berupa kode tunjangan, nama tunjangan, dan nilai tunjangan.

d. Tabel Pengangkatan <br>
   Tabel ini menyediakan data pengangkatan seseorang menjadi pegawai tetap. Ketika diangkat, 
   maka dia mendapatkan penempatan pada sebuah divisi dan diangkat berdasarkan sebuah SK
   (Surat Keputusan).
   Tabel ini menyimpan data berupa kode karyawan, nama divisi, tanggal pengangkatan, dan nomor SK.
   

Tabel IMPLEMENTS
a.  Tabel Pegawai
    Tabel ini menampung data berupa informasi dasar pegawai. Menyimpan nama, kode, tanggal lahir, 
    jenis kelamin, status pernikahan, jabatan, dan tanggal masuk pegawai.

    Tabel ini mengimplementasikan tabel Jabatan, tapi tabel ini sendiri merupakan sebuah source 
    untuk beberapa tabel lainnya.

b. Tabel Detail
   Tabel ini menampung data berupa informasi pernikahan pegawai. Menyimpan nama istri / suami dan 
   jumlah anak yang dimiliki pegawai. 

   Ketika ingin menginput data pada tabel ini, user pertama harus menginput kode pegawai. 
   Sistem akan mencari apakah terdapat pegawai dengan kode tersebut. Apabila kode pegawai tidak 
   ditemukan atau status pernikahan pegawai tidak cocok, maka user tidak akan bisa meneruskan input.

   Tabel ini mengimplementasikan tabel Pegawai.

c. Tabel Posisi
   Tabel ini menyimpan data berupa informasi periode jabatan pegawai. Menyimpan tanggal mulai, 
   tanggal selesai, dan jumlah periode seorang pegawai dalam menjabat.

   Ketika ingin menginput data pada tabel ini, user pertama harus menginput kode pegawai. 
   Sistem akan mencari apakah terdapat pegawai dengan kode tersebut. Apabila kode pegawai ditemukan 
   maka sistem akan menunjukkan jabatan pegawai yang bersangkutan dan mengizinkan user untuk 
   meng-input tanggal mulai dan selesai jabatan, dan memilih jumlah periode jabatan yang diinginkan.

   Apabila kode pegawai tidak ditemukan, sistem akan mengunci semua field dalam tabel untuk 
   mencegah input lebih lanjut.

   Tabel ini mengimplementasikan tabel Pegawai dan Jabatan.

d. Tabel Gaji
   Tabel ini menyimpan data berupa informasi gaji total pegawai. Gaji total merupakan gabungan 
   dari gaji pokok sejumlah 2.500.000 ditambah tunjangan yang dipilih oleh user. Tabel ini 
   menyimpan kode karyawan, divisi karyawan, tunjangan yang diambil, tanggal pengambilan gaji 
   setiap bulan, dan total gaji yang diterima.

   Ketika ingin menginput data pada tabel ini, user pertama harus menginput kode karyawan dari 
   tabel Pengangkatan. Sistem akan mencari apakah terdapat entry dengan kode tersebut. Apabila 
   kode karyawan ditemukan, maka user akan menunjukkan divisi karyawan yang bersangkutan dan 
   meng-enable pemilihan tunjangan.

   Apabila kode pegawai tidak ditemukan, sistem akan mengunci semua field dalam tabel untuk 
   mencegah input lebih lanjut.

   Tabel ini mengimplementasikan tabel Divisi dan Tunjangan.


3. Informasi Pemakaian <br>
###################### <br>
Ketika menjalankan program, user akan diminta untuk melakukan login terlebih dahulu. Pada state 
ini, semua pilihan pada menu bar terkunci kecuali opsi Help, yang memungkinkan user membuka file 
teks Readme (file ini) dan file About (berisi informasi struktural dan fisik program).

Apabila username dan password tidak terisi dengan benar, akan muncul sebuah message dialog yang 
memberikan warning message kepada user.

Untuk mengakses aplikasi, masukkan value berikut (tanpa tanda " "):

Username: user
Password: pass

Ketika login berhasil, maka panel akan sendirinya hilang dan menu bar akan terbuka.
Jika user membatalkan login, maka aplikasi secara keseluruhan akan tertutup.
