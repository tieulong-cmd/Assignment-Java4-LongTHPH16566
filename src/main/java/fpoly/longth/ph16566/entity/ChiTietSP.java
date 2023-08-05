package fpoly.longth.ph16566.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    @Column(name = "IdSP")
    private String idSP;

    @Column(name = "IdNsx")
    private String idNsx;

    @Column(name = "IdMauSac")
    private String idMauSac;

    @Column(name = "IdDongSP")
    private String idDongSP;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Double giaNhap;

    @Column(name = "GiaBan")
    private Double giaBan;
}
