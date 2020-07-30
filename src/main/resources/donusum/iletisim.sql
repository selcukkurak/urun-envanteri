select 'id' as id,
       iletisim_ic_ad_soyad as ad_soyad,
       iletisim_ic_unvan as unvan,
       iletisim_ic_birim as dis_birim_adi,
       iletisim_ic_telefon as telefon,
       iletisim_ic_eposta as eposta,
       idari_kayit_kod as idari_kayit_id,
       false as kurum_disi
from idarikayit_iletisim_ic
union all
select 'id' as id,
       iletisim_dis_ad_soyad as ad_soyad,
       iletisim_dis_unvan as unvan,
       iletisim_dis_birim as dis_birim_adi,
       iletisim_dis_telefon as telefon,
       iletisim_dis_eposta as eposta,
       idari_kayit_kod as idari_kayit_id,
       true as kurum_disi
from idarikayit_iletisim_dis;
