select 'id' as id,
       istatistiki_urun_ad as adi,
       urun_id as kodu,
       csa,
       ic_birim_kod as birim_id,
       false as taslak,
       (select id from rf_toplu r where r.kodu = uretim_siklik::integer and tipi = 'PERIYOT') as periyot_id,
       (select id from rf_toplu r where r.kodu = cografi_duzey_kod::integer and tipi = 'COGRAFI_DUZEY') as cografi_duzey_id,
       true as uretiliyor
from istatistiki_urun order by istatistiki_urun_kod::integer;

-- İlişki tabloları için lazım olacak
create table urun_gecici as
select row_number() over (order by u.istatistiki_urun_kod::integer) as urun_id,
       u.urun_id as msd_urun_id,
       u.istatistiki_urun_kod as eski_urun_id,
       u.istatistiki_urun_ad as adi
from istatistiki_urun u
order by id