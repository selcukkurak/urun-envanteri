select idari_kayit_kod as id,
       idari_kayit_ad as adi,
       veri_icerik as icerik,
       kaynak_kurum_dtvt_id as kaynak_kurum_dtvt,
       kaynak_birim_dtvt_id as kaynak_birim_dtvt,
       (select id from rf_toplu r where r.kodu = kaynak_kurum::integer and tipi = 'KAYNAK_KURUM') as kaynak_kurum_id,
       null as kaynak_kurum_adi,
       kaynak_birim as kaynak_birim_adi,
       sorumlu_birim as birim_id,
       transfer_sorumlu_birim as transferden_sorumlu_birim_id,
       eposta_grup as eposta_gruplari,
       csa,
       verinin_tutuldugu_sema as sema,
       verinin_tutuldugu_veritabani as veritabani,
       tercih_neden as tercih_nedeni,
       alternatif_kaynak,
       kisitlar,
       (select id from rf_toplu r where r.kodu = cografi_duzey_kod::integer and tipi = 'COGRAFI_DUZEY') as cografi_duzey_id,
       (select id from rf_toplu r where r.kodu = veri_kullanim_amac::integer and tipi = 'VERI_KULLANIM_AMACI') as kullanim_amaci_id,
       veri_kullanim_amac_diger_aciklama as kullanim_amaci_diger_aciklama,
       (select id from rf_toplu r where r.kodu = veri_duzeyi::integer and tipi = 'VERI_DUZEYI') as veri_duzeyi_id,
       (select id from rf_toplu r where r.kodu = veri_kaynak_bicim::integer and tipi = 'VERI_KAYNAK_BICIMI') as bicim_id,
       veri_kaynak_bicim_diger_aciklama as bicim_diger_aciklama,
       (select id from rf_toplu r where r.kodu = veri_aktarim_bicim::integer and tipi = 'VERI_AKTARIM_BICIMI') as aktarim_bicimi_id,
       veri_aktarim_bicim_aciklama as aktarim_bicimi_diger_aciklama,
       (select id from rf_toplu r where r.kodu = transfer_siklik::integer and tipi = 'PERIYOT') as transfer_periyot_id,
       transfer_siklik_aciklama as transfer_periyot_aciklama,
       yasal_hukum,
       veri_teslimat_sartlari as teslimat_sartlari,
       (select id from rf_toplu r where r.kodu = verinin_tutuldugu_yer::integer and tipi = 'VERININ_TUTULDUGU_YER') as verinin_tutuldugu_yer_id,
       verinin_tutuldugu_yer_aciklama as verinin_tutuldugu_yer_diger_aciklama,
       (select id from rf_toplu r where r.kodu = veri_talep_bicim::integer and tipi = 'VERI_TALEP_BICIMI') as talep_bicimi_id,
       veri_talep_bicim_diger_aciklama as talep_bicimi_diger_aciklama,
       (select id from rf_toplu r where r.kodu = istatistiki_birim_duzey::integer and tipi = 'ISTATISTIKI_BIRIM_DUZEY') as birim_duzeyi_id,
       istatistiki_birim_duzey_diger_aciklama as birim_duzeyi_diger_aciklama
from idari_kayit_envanteri;

select distinct kodu from rf_toplu where tipi = 'KAYNAK_KURUM';
select distinct kod from rf_kaynak_kurum;
select ad, kod from rf_kaynak_kurum group by ad, kod having count(*) > 1;