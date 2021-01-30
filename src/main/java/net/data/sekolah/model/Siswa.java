package net.data.sekolah.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.data.sekolah.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "siswa")
public class Siswa {

    @Id
    @Column(name = "NIS")
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "nama_siswa")
    @JsonProperty("nama_siswa")
    private String name;


    @NotNull
    @Column(name = "ttl")
    @JsonProperty("ttl")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ttl;

    public String showDate() {
        return DateUtils.dateToString(ttl);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kelas_id")
    private Kelas kelas;



    @Column(name = "alamat")
    @JsonProperty("alamat")
    private String alamat;

    @NotNull
    @Column(name = "namaortua")
    @JsonProperty("namaortua")
    private String namaortua;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTtl() {
        return ttl;
    }

    public void setTtl(Date ttl) {
        this.ttl = ttl;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamaortua() {
        return namaortua;
    }

    public void setNamaortua(String namaortua) {
        this.namaortua = namaortua;
    }
}
