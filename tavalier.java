import java.util.ArrayList;

class Tavalier extends Piece {

    public Tavalier() {
        super('B', new Position());
    }

    public Tavalier(char couleur, Position position) {
        super(couleur, position);
    }

    public String getType() {
        return "tavalier";
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl) {
        ArrayList<Position> liste = new ArrayList<Position>();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();

        // === Déplacements de cavalier ===
        int[][] deplacementsCavalier = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
        };

        for (int[] move : deplacementsCavalier) {
            int nx = x + move[0];
            int ny = y + move[1];
            if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                Piece pi = pl.getCase(nx, ny);
                if (pi == null || pi.getCouleur() != this.getCouleur()) {
                    liste.add(new Position(nx, ny));
                }
            }
        }

        // === Déplacements de tour ===

        // Bas
        int i = y - 1;
        while (i >= 0) {
            Piece pi = pl.getCase(x, i);
            if (pi == null)
                liste.add(new Position(x, i));
            else {
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(x, i));
                break;
            }
            i--;
        }

        // Haut
        i = y + 1;
        while (i < 8) {
            Piece pi = pl.getCase(x, i);
            if (pi == null)
                liste.add(new Position(x, i));
            else {
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(x, i));
                break;
            }
            i++;
        }

        // Gauche
        i = x - 1;
        while (i >= 0) {
            Piece pi = pl.getCase(i, y);
            if (pi == null)
                liste.add(new Position(i, y));
            else {
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(i, y));
                break;
            }
            i--;
        }

        // Droite
        i = x + 1;
        while (i < 8) {
            Piece pi = pl.getCase(i, y);
            if (pi == null)
                liste.add(new Position(i, y));
            else {
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(i, y));
                break;
            }
            i++;
        }

        return liste;
    }
}
