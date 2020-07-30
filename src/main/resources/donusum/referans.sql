select 'id' as id, kod as kodu, ad as adi, 'ARAC' as tipi from rf_arac;
select 'id' as id, kod as kodu, ad as adi, 'ISTATISTIKI_BIRIM_DUZEY' as tipi from rf_istatistiki_birim_duzey;
select 'id' as id, kod as kodu, ad as adi, 'COGRAFI_DUZEY' as tipi from rf_cografi_duzey;
select 'id' as id, kod as kodu, ad as adi, 'KAYNAK_KURUM' as tipi from rf_kaynak_kurum;
select 'id' as id, kod as kodu, ad as adi, 'KURULUS' as tipi from rf_kurum_kurulus;
select 'id' as id, kod as kodu, ad as adi, 'PERIYOT' as tipi from rf_periyot;
select 'id' as id, kod as kodu, ad as adi, 'VALIDASYON_TIPI' as tipi from rf_validasyon_tipi;
select 'id' as id, kod as kodu, ad as adi, 'VERI_AKTARIM_BICIMI' as tipi from rf_veri_aktarim_bicim;
select 'id' as id, kod as kodu, ad as adi, 'VERI_DUZEYI' as tipi from rf_veri_duzey;
select 'id' as id, kod as kodu, ad as adi, 'VERI_KAYNAK_BICIMI' as tipi from rf_veri_kaynak_bicim;
select 'id' as id, kod as kodu, ad as adi, 'VERI_KULLANIM_AMACI' as tipi from rf_veri_kullanim_amac;
select 'id' as id, kod as kodu, ad as adi, 'VERI_TALEP_BICIMI' as tipi from rf_veri_talep_bicim;
select 'id' as id, kod as kodu, ad as adi, 'VERININ_TUTULDUGU_YER' as tipi from rf_verinin_tutuldugu_yer;

-- Diğerlerine id sağlamak için lazım olacak
create table rf_toplu as select * from referans;
