select 'id' as id, u.id as urun_id, hb_id as bulten_id
from istatistiki_urun_haber_bulteni ub, urun_gecici u
where ub.istatistiki_urun_kod::integer = u.eski_urun_id;