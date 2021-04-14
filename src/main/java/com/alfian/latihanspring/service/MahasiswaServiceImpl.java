package com.alfian.latihanspring.service;

import com.alfian.latihanspring.models.dto.MahasiswaDto;
import com.alfian.latihanspring.models.entity.Mahasiswa;
import com.alfian.latihanspring.repository.MahasiswaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class MahasiswaServiceImpl implements MahasiswaService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Override
    public Mahasiswa insertData(@RequestBody MahasiswaDto mahasiswaDto) {
        Mahasiswa mahasiswa = new Mahasiswa();
        if (!mahasiswaDto.getNama().isEmpty()) {
            mahasiswa.setNama(mahasiswaDto.getNama());
            mahasiswa.setJurusan(mahasiswaDto.getJurusan());
            mahasiswa.setNim(mahasiswaDto.getNim());
            mahasiswa.setTanggalLahir(mahasiswaDto.getTanggalLahir());
            mahasiswa.setDomisili(mahasiswaDto.getDomisili());

            mahasiswaRepository.save(mahasiswa);
            return mahasiswa;
        }
        return null;
    }

    @Override
    public Mahasiswa updateData(@PathVariable Integer id, @RequestBody MahasiswaDto mahasiswaDto) {
        // TODO Auto-generated method stub
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id).get();

        return null;
    }

}
