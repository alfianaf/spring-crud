package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.MahasiswaDto;
import com.alfian.latihanspring.models.dto.StatusMessageDto;
import com.alfian.latihanspring.models.entity.DetailUser;
import com.alfian.latihanspring.models.entity.Domisili;
import com.alfian.latihanspring.models.entity.User;
import com.alfian.latihanspring.repository.DetailUserRepository;
import com.alfian.latihanspring.repository.DomisiliRepository;
import com.alfian.latihanspring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DetailUserRepository detailUserRepository;
    @Autowired
    private DomisiliRepository domisiliRepository;

    @Override
    public ResponseEntity<?> regist(@RequestBody MahasiswaDto mahasiswaDto) {
        // TODO Auto-generated method stub
        StatusMessageDto<User> result = new StatusMessageDto<>();

        if (mahasiswaDto.getNik().length() != 16) {
            result.setStatus(HttpStatus.BAD_REQUEST.value());
            result.setMessage("NIK harus berjumlah 16 angka.");
            return ResponseEntity.badRequest().body(result);
        }
        // if (mahasiswaDto.getGolDarah() != "B" ||
        // !mahasiswaDto.getGolDarah().equalsIgnoreCase("A")
        // || !mahasiswaDto.getGolDarah().equalsIgnoreCase("O")
        // || !mahasiswaDto.getGolDarah().equalsIgnoreCase("AB")) {
        // result.setStatus(HttpStatus.BAD_REQUEST.value());
        // result.setMessage("Golongan darah harus valid! (A, B, O, atau AB)" +
        // mahasiswaDto.getGolDarah().toString());
        // return ResponseEntity.badRequest().body(result);
        // }
        User user = new User();
        DetailUser detailUser = new DetailUser();
        Domisili domisili = new Domisili();

        user.setUsername(mahasiswaDto.getUsername());
        user.setPassword(mahasiswaDto.getPassword());
        userRepository.save(user);

        detailUser.setFirstName(mahasiswaDto.getFirstName());
        detailUser.setLastName(mahasiswaDto.getLastName());
        detailUser.setNik(mahasiswaDto.getNik());
        detailUser.setTanggalLahir(mahasiswaDto.getTanggalLahir());
        detailUser.setGolDarah(mahasiswaDto.getGolDarah());
        detailUser.setUser(user);
        detailUserRepository.save(detailUser);

        domisili.setKelurahan(mahasiswaDto.getKelurahan());
        domisili.setKecamatan(mahasiswaDto.getKecamatan());
        domisili.setProvinsi(mahasiswaDto.getProvinsi());
        domisili.setDetailUser(detailUser);
        domisiliRepository.save(domisili);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil tersimpan!");
        result.setData(user);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody MahasiswaDto mahasiswaDto) {
        // TODO Auto-generated method stub
        StatusMessageDto<User> result = new StatusMessageDto<>();

        User user = userRepository.findById(id).get();
        DetailUser detailUser = detailUserRepository.findById(user.getId() + 1).get();
        Domisili domisili = domisiliRepository.findById(detailUser.getId() + 1).get();

        if (!mahasiswaDto.getUsername().isEmpty()) {
            user.setUsername(mahasiswaDto.getUsername());
        }
        if (!mahasiswaDto.getPassword().isEmpty()) {
            user.setPassword(mahasiswaDto.getPassword());
        }
        // userRepository.save(user);

        detailUser.setFirstName(mahasiswaDto.getFirstName());
        detailUser.setLastName(mahasiswaDto.getLastName());
        detailUser.setNik(mahasiswaDto.getNik());
        detailUser.setTanggalLahir(mahasiswaDto.getTanggalLahir());
        detailUser.setGolDarah(mahasiswaDto.getGolDarah());
        detailUser.setUser(user);
        // detailUserRepository.save(detailUser);

        domisili.setKelurahan(mahasiswaDto.getKelurahan());
        domisili.setKecamatan(mahasiswaDto.getKecamatan());
        domisili.setProvinsi(mahasiswaDto.getProvinsi());
        domisili.setDetailUser(detailUser);
        // domisiliRepository.save(domisili);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil diubah!");
        result.setData(user);
        return ResponseEntity.ok(result);

    }

    @Override
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        StatusMessageDto<User> result = new StatusMessageDto<>();
        User user = userRepository.findById(id).get();
        DetailUser detailUser = detailUserRepository.findById(user.getId() + 1).get();
        Domisili domisili = domisiliRepository.findById(detailUser.getId() + 1).get();

        userRepository.delete(user);
        detailUserRepository.delete(detailUser);
        domisiliRepository.delete(domisili);
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil dihapus!");
        result.setData(user);
        return ResponseEntity.ok(result);
    }

}
