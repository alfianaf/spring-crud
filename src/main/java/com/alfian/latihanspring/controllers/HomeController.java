package com.alfian.latihanspring.controllers;

import java.util.List;

import com.alfian.latihanspring.helper.Json;
import com.alfian.latihanspring.models.dto.MahasiswaDto;
import com.alfian.latihanspring.models.entity.Mahasiswa;
import com.alfian.latihanspring.repository.MahasiswaRepository;
import com.alfian.latihanspring.service.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HomeController {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    @Autowired
    private MahasiswaService mahasiswaService;

    @RequestMapping("/")
    public String Home() {
        System.out.println("Hello");
        return "home";
    }

    @GetMapping("/newmahasiswa")
    public List<?> getAll() {
        List<Mahasiswa> persons = mahasiswaRepository.findAll();
        return persons;
    }

    @PostMapping("/newmahasiswa/add")
    public ResponseEntity<?> add(@RequestBody MahasiswaDto mahasiswaDto) {
        try {
            // Mahasiswa mahasiswa = new Mahasiswa();

            // mahasiswa.setNama(mahasiswaDto.getNama());
            // mahasiswa.setJurusan(mahasiswaDto.getJurusan());
            // mahasiswa.setNim(mahasiswaDto.getNim());
            // mahasiswa.setTanggalLahir(mahasiswaDto.getTanggalLahir());
            // mahasiswa.setDomisili(mahasiswaDto.getDomisili());

            // Mahasiswa[] resultArray = { mahasiswa };
            // Json json = new Json(true, "Berhasil menambahkan data", resultArray);

            // mahasiswaRepository.save(mahasiswa);
            Mahasiswa mahasiswa = mahasiswaService.insertData(mahasiswaDto);
            Mahasiswa[] resultArray = { mahasiswa };
            Json json = new Json(true, "Berhasil menambahkan data", resultArray);
            return ResponseEntity.ok(json);
        } catch (Exception e) {

            // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/newmahasiswa/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id).get();
        Mahasiswa[] resultArray = { mahasiswa };
        return ResponseEntity.ok(resultArray);
    }

    @PutMapping("/newmahasiswa/edit/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody MahasiswaDto mahasiswaDto) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id).get();

        mahasiswa.setNama(mahasiswaDto.getNama());
        mahasiswa.setJurusan(mahasiswaDto.getJurusan());
        mahasiswa.setNim(mahasiswaDto.getNim());
        mahasiswa.setTanggalLahir(mahasiswaDto.getTanggalLahir());
        mahasiswa.setDomisili(mahasiswaDto.getDomisili());

        mahasiswaRepository.save(mahasiswa);
        return ResponseEntity.ok(mahasiswa);
    }

    @DeleteMapping("/newmahasiswa/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id).get();
        mahasiswaRepository.delete(mahasiswa);

        return ResponseEntity.ok(mahasiswa);
    }

    @GetMapping("/mahasiswa")
    public @ResponseBody Iterable<Mahasiswa> all() {
        // This returns a JSON or XML with the users
        return mahasiswaRepository.findAll();
    }

    @GetMapping(path = "/mahasiswa/detail")
    public @ResponseBody Json detail(@RequestParam Integer id) {
        Object object = mahasiswaRepository.findById(id);

        Object[] mahasiswaRes = { object };
        Json json = new Json(true, "Berhasil menampilkan data", mahasiswaRes);
        System.out.println("test");
        return json;
    }

    @PostMapping("/mahasiswa/add")
    public @ResponseBody Json add(@RequestParam String nama, @RequestParam String jurusan, @RequestParam String nim) {

        Mahasiswa n = new Mahasiswa();
        n.setNama(nama);
        n.setJurusan(jurusan);
        n.setNim(nim);
        mahasiswaRepository.save(n);
        Mahasiswa[] mahasiswa = { n };

        Json json = new Json(true, "Berhasil menampilkan data", mahasiswa);
        System.out.println("test");
        return json;
    }

    @PostMapping("/mahasiswa/edit")
    public @ResponseBody Json add(@RequestParam Integer id, Mahasiswa mahasiswa) {
        mahasiswa.setId(id);
        mahasiswaRepository.save(mahasiswa);

        Mahasiswa[] mahasiswaRes = { mahasiswa };
        Json json = new Json(true, "Berhasil mengubah data", mahasiswaRes);
        System.out.println("test");
        return json;
    }

    @GetMapping("/mahasiswa/delete")
    public @ResponseBody Json add(@RequestParam Integer id) {
        Object object = mahasiswaRepository.findById(id);
        mahasiswaRepository.deleteById(id);

        Object[] mahasiswaRes = { object };
        Json json = new Json(true, "Berhasil menghapus data", mahasiswaRes);
        System.out.println("test");
        return json;
    }
}
