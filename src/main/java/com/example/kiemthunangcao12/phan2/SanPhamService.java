package com.example.kiemthunangcao12.phan2;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {

    private List<SanPham> danhSachSanPham = new ArrayList<>();

    public void themSanPham(SanPham sp) {
        if (sp == null) {
            throw new IllegalArgumentException("Sản phẩm không được null");
        }
        if (sp.getMa() == null || sp.getMa().trim().isEmpty()) {
            throw new IllegalArgumentException("Mã sản phẩm không được để trống");
        }
        if (kiemTraMaSanPhamTonTai(sp.getMa())) {
            throw new IllegalArgumentException("Mã sản phẩm " + sp.getMa() + " đã tồn tại.");
        }

        danhSachSanPham.add(sp);
    }

    /**
     *
     *
     * @param maSanPham
     * @param sanPhamMoi
     * @throws IllegalArgumentException
     */
    public void suaSanPham(String maSanPham, SanPham sanPhamMoi) {
        // Validate
        if (maSanPham == null || maSanPham.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã sản phẩm không được để trống.");
        }

        if (sanPhamMoi == null) {
            throw new IllegalArgumentException("Sản phẩm mới không được null.");
        }

        if (sanPhamMoi.getTen() == null || sanPhamMoi.getTen().trim().isEmpty() ||
                sanPhamMoi.getDanhMuc() == null || sanPhamMoi.getDanhMuc().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên và danh mục sản phẩm không được để trống.");
        }

        if (sanPhamMoi.getNamBaoHanh() < 0) {
            throw new IllegalArgumentException("Năm bảo hành không được nhỏ hơn 0.");
        }

        if (sanPhamMoi.getGia() <= 0) {
            throw new IllegalArgumentException("Giá sản phẩm phải lớn hơn 0.");
        }

        if (sanPhamMoi.getSoLuong() < 0) {
            throw new IllegalArgumentException("Số lượng sản phẩm không được nhỏ hơn 0.");
        }

        SanPham sanPham = timSanPhamTheoMa(maSanPham); // Tìm sản phẩm cần sửa
        if (sanPham == null) {
            throw new IllegalArgumentException("Không tìm thấy sản phẩm có mã " + maSanPham);
        }

        sanPham.setTen(sanPhamMoi.getTen());
        sanPham.setNamBaoHanh(sanPhamMoi.getNamBaoHanh());
        sanPham.setGia(sanPhamMoi.getGia());
        sanPham.setSoLuong(sanPhamMoi.getSoLuong());
        sanPham.setDanhMuc(sanPhamMoi.getDanhMuc());
    }

    /**
     *
     *
     * @param ma
     * @return
     */
    public SanPham timSanPhamTheoMa(String ma) {
        for (SanPham sp : danhSachSanPham) {
            if (sp.getMa().equals(ma)) {
                return sp;
            }
        }
        return null;
    }

    //kiểm tra ton tại mã
    /**
     *
     *
     * @param maSanPham
     * @return
     */
    private boolean kiemTraMaSanPhamTonTai(String maSanPham) {
        for (SanPham sp : danhSachSanPham) {
            if (sp.getMa().equals(maSanPham)) {
                return true;
            }
        }
        return false;
    }
}