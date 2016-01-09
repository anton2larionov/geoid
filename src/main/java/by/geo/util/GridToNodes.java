package by.geo.util;

import by.geo.point.Grid;
import by.geo.point.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Преобразователь грида в коллекцию узлов.
 */
public final class GridToNodes {

    private final Grid grid;

    /**
     * @param grid грид
     */
    public GridToNodes(final Grid grid) {
        this.grid = Objects.requireNonNull(grid);
    }

    /**
     * Получить коллекцию узлов.
     *
     * @return коллекция узлов
     */
    public Collection<Node> knots() {

        final double lon0 = grid.lonMin();
        final double lat0 = grid.latMin();

        final double dlon = grid.deltaLon();
        final double dlat = grid.deltaLat();

        final Collection<Node> nodes = new ArrayList<>();

        for (int i = 0; i < grid.rowNumber(); i++) {
            for (int j = 0; j < grid.colNumber(); j++) {
                nodes.add(new Node(
                        lat0 + dlat * i, lon0 + dlon * j,
                        i, j));
            }
        }
        return nodes;
    }
}
