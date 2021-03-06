package sk.fei.tp.ease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.fei.tp.ease.dto.domain.graph.ObjectRelationsGraphProjection;
import sk.fei.tp.ease.dto.domain.search.ConnectorFilterDataDto;
import sk.fei.tp.ease.model.EConnector;
import sk.fei.tp.ease.model.enums.ConnectorType;

import java.util.List;

@Repository
public interface EConnectorRepository extends JpaRepository<EConnector, Long> {


    @Query("select new sk.fei.tp.ease.dto.domain.graph.ObjectRelationsGraphProjection(" +
            " edge.startObject.id, edge.startObject.name," +
            " edge.endObject.id, edge.endObject.name," +
            " edge.connectorType," +
            " edge.stereotype, " +
            " edge.startObject, " +
            " edge.endObject)" +
            " from EConnector edge " +
            "   where edge.startObject.id = :rootObjectId " +
            "       and edge.startObject.type <> 'Port' " +
            "       and edge.endObject.type <> 'Port' ")
    List<ObjectRelationsGraphProjection> findObjectGraphOutgoing(@Param("rootObjectId") Long rootObjectId);

    @Query("select new sk.fei.tp.ease.dto.domain.graph.ObjectRelationsGraphProjection(" +
            " edge.startObject.id, edge.startObject.name, " +
            " edge.endObject.id, edge.endObject.name, " +
            " edge.connectorType," +
            " edge.stereotype, " +
            " edge.startObject, " +
            " edge.endObject)" +
            " from EConnector edge" +
            "   where (:connectorType is null or edge.connectorType = :connectorType) ")
    List<ObjectRelationsGraphProjection> findCompleteGraph(@Param("connectorType") ConnectorType connectorType);

    @Query("select new sk.fei.tp.ease.dto.domain.graph.ObjectRelationsGraphProjection(" +
            " edge.startObject.parent.id, edge.startObject.parent.name, " +
            " edge.endObject.parent.id, edge.endObject.parent.name, " +
            " edge.connectorType," +
            " edge.stereotype," +
            " edge.startObject, " +
            " edge.endObject)" +
            " from EConnector edge" +
            "   where (:connectorType is null or edge.connectorType = :connectorType) ")
    List<ObjectRelationsGraphProjection> findCompleteGraphWithPortConnections(@Param("connectorType") ConnectorType connectorType);

    @Query("select distinct new sk.fei.tp.ease.dto.domain.search.ConnectorFilterDataDto(" +
            " edge.connectorType, edge.stereotype ) from EConnector edge")
    List<ConnectorFilterDataDto> findAllConnectorTypes();
}
