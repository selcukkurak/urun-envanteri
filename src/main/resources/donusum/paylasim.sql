select 'id' as id,
       cikti_paylasim_adi as adi,
       (select id from rf_toplu r where r.kodu = arac_kod::integer and tipi = 'ARAC') as arac_id,
       (select id from rf_toplu r where r.kodu = kurum_kod::integer and tipi = 'KURULUS') as kurulus_id,
       (select id from rf_toplu r where r.kodu = periyot_kod::integer and tipi = 'PERIYOT') as periyot_id,
       u.urun_id
from istatistiki_urun_cikti c, urun_gecici u where c.urun_id = u.msd_urun_id;
