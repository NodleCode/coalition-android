/*
 * This file is part of the Whisper Protocol distributed at https://github.com/NodleCode/whisper-tracing-android
 * Copyright (C) 2020  Coalition Network
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package world.coalition.whisper.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.RowId

/**
 * @author Lucien Loiseau on 07/04/20.
 */
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = PeerTid::class,
            parentColumns = ["row_id"],
            childColumns = ["peer_tid_rowid"],
            onDelete = ForeignKey.CASCADE
        )]
)
data class PeerPingEvent(
    @ColumnInfo(name = "peer_tid_rowid", index = true) val peerTidRowId: Long,
    @ColumnInfo(name = "ping_timestamp_ms") val pingTimestampMs: Long,
    @ColumnInfo(name = "elapsed_time_duration") val elapsedTimeDuration: Long
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "row_id", index = true)
    var id: Long = 0
}