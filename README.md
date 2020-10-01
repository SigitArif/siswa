# How to run

1. install java
2. install maven
3. ubah variable input FILE_PATH pada src/main/java/converter/ConvertCSVtoModel menjadi path direktori dari file siswa.csv dan nilai.csv anda
4. Set cron scheduler sesuai kebutuhan pada cron.input.schedule pada application.properties (nilai default akan secara otomatis update data tiap pukul 13.00)
5. mvn clean install -DskipTests
6. mvn spring-boot:run
7. untuk saat ini setiap scheduler berjalan aplikasi akan menghapus data sebelumnya dan menginput ulang data dari file csv, belum mampu secara dinamis untuk memfilter, dan menambah data baru saja

# APIs

1. Get List Nilai
   - HTTP Method: POST
   - url: localhost:8080/siswa-service/api/v1/nilai/list
   - request_body: {
    "no_induk": "1", 
    "nama" : "Deni",
    "mata_pelajaran" : "agama", 
    "nilai" : "60"
   }
   - semua input dalam string apabila tidak ingin melakukan filter maka kirimkan request JSON kosong {}. 
   - Filter baru bisa dalam exact value belum bisa >/ <

2. Update Nilai
   - HTTP Method: UPDATE 
   - url: localhost:8080/siswa-service/api/v1/nilai/update 
   - request_body: { 
     "no_induk": "1", 
    "nama" : "Deni",
    "mata_pelajaran" : "agama", 
    "nilai" : "80"   
    }
   - Semua input harus dalam String. nama dan no_induk harus sesuai, belum ditambahkan validasi pengecekan.

3. Delete Mapel
   - HTTP Method: DELETE
   - url: localhost:8080/siswa-service/api/v1/nilai/mapel/delete?mapel=agama
   - value mapel yang ingin dihapus dimasukkan dalam param 'mapel'. 
   - Harus sesuai penamaan/besar kecilnya. 