select urun_id, anket_kod as anket_id
from istatistiki_urun_anket ua, urun_gecici u
where ua.istatistiki_urun_kod = u.eski_urun_id;
