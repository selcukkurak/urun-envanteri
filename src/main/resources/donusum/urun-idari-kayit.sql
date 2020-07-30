select urun_id, idari_kayit_kod as idari_kayit_id
from istatistiki_urun_idari_kayit ua, urun_gecici u
where ua.istatistiki_urun = u.eski_urun_id;
